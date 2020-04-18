"# installment" 

Сборка 
gradlew install
gradlew setupTomcat deploy
gradlew startDb
gradlew createDb
gradlew start


Создание docker image
docker build -t xb .

Запустить приложение
docker-compose up


командная строка 
docker container run -i -t -p 8080:8080 xb


docker run -p 8080:8080 -v d:/docker/xb:/opt/xb-home xb