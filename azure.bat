cmd /k mvnw.cmd package
mkdir webapps
copy target/azure-pki-1.0.war webapps