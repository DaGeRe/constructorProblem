# Kieker Constructor Problem

This demonstrates a problem with kieker instrumentation: if a default constructor is instrumented, the signature contains a wrong visibility.

To try it, run `mvn clean package && java -Djava.io.tmpdir=kiekerTest -javaagent:/home/$USER/.m2/repository/net/kieker-monitoring/kieker/1.14/kieker-1.14-aspectj.jar -cp target/constructor-problem-0.0.1-SNAPSHOT.jar de.peass.C0_0` (assuming your maven home is the default ~/.m2, but -javaagent does not parse ~ correctly) and have a look at the results in `kiekerTest`.

The results will look like this:

```
cat kiekerTest/kieker-20210126-095704-2253364301465-UTC--KIEKER-constructorDemo/kieker-20210126-095704296-UTC-001.dat | grep init
$1;1611655024307701186;de.peass.C0_0.<init>();<no-session-id>;4255197960423342081;1611655024307589790;1611655024307592829;reichelt-desktop;1;1
$1;1611655024313154073;de.peass.C1_0.<init>();<no-session-id>;4255197960423342081;1611655024313146834;1611655024313151304;reichelt-desktop;3;2
$1;1611655024318983369;de.peass.C2_0.<init>();<no-session-id>;4255197960423342081;1611655024318976619;1611655024318980549;reichelt-desktop;5;3
$1;1611655024332249629;public de.peass.AddRandomNumbers.<init>();<no-session-id>;4255197960423342081;1611655024332241989;1611655024332246419;reichelt-desktop;7;4
$1;1611655024335383810;public de.peass.AddRandomNumbers.<init>();<no-session-id>;4255197960423342081;1611655024335380780;1611655024335381910;reichelt-desktop;159;4
$1;1611655024345931315;de.peass.C2_1.<init>();<no-session-id>;4255197960423342081;1611655024345923916;1611655024345929006;reichelt-desktop;311;3
$1;1611655024346061531;de.peass.C0_0.<init>();<no-session-id>;4255197960423342081;1611655024346059741;1611655024346060761;reichelt-desktop;314;1
$1;1611655024352465778;de.peass.C1_1.<init>();<no-session-id>;4255197960423342081;1611655024352459349;1611655024352464039;reichelt-desktop;316;2
$1;1611655024358118520;de.peass.C2_2.<init>();<no-session-id>;4255197960423342081;1611655024358112320;1611655024358116940;reichelt-desktop;318;3
$1;1611655024363677234;de.peass.C2_3.<init>();<no-session-id>;4255197960423342081;1611655024363670854;1611655024363675404;reichelt-desktop;322;3
```

But the default constructors signature should be public, e.g. `public de.peass.C0_0.<init>()`.
