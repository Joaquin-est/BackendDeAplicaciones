mvn compile
java -cp target/classes com.joaco.App

mvn exec:java "-Dexec.mainClass=com.frc.utn.isi.backend.viajes.App"

mvn archetype:generate "-DgroupId=com.joaco" "-DartifactId=segundo-proyecto" "-DarchetypeGroupId=org.apache.maven.archetypes" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"

mvn archetype:generate "-DgroupId=com.frc.utn.isi.backend.pagos" -DartifactId="App-EventosCasaInteligente" -DarchetypeGroupId="org.apache.maven.archetypes" -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
