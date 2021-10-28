Etapa 1 
  Instalar o lambok.jar no eclise caso não exista.
Etapa 2
 Instalar driver ojdb7.jar da oracle o script para estar dentro de db.
Etapa 3
 instalar cetificado digital auto assinado exemplo nesse link :https://howtodoinjava.com/spring-boot/spring-boot-ssl-https-example/
 executar esse comando no linux.

keytool -genkey -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -validity 700 -keypass changeit -storepass changeit -keystore ssl-server.jks


gerar builder 

DskipTests=true clean package

