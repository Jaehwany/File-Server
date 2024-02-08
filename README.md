# File-Service

Spring Boot + docker로 구성한 파일 서버
<br><br>
 
0. git clone 

```
$ git clone https://github.com/Jaehwany/File-Service.git
```
<br>

1. Spring Boot build

```
$ cd File-Service/file-service
$ sudo chmod +x gradlew
$ ./gradlew build
```
<br>

2. Docker Image build

```
$ docker build -t file-service:0.1 ./
```
<br>


3. Docker run

```
$ docker run -d -p $TARGET_PORT:8080 -v /files:/uploads --name file-service file-service:0.1
```
<br>

<br>

> API<br>
1. File Upload <br>
```POST http://{baseUrl}/upload``` <br><br>
2. Multi-File Upload<br> ```POST http://{baseUrl}/uploads``` <br><br>
3. File Download<br>```GET http://{baseUrl}/download/{fileName+.}```
