# FileServer

Spring Boot + docker로 구성한 나만의 파일 서버
<br><br>


1. Docker Image build

```
$ docker build -t file-service:0.1 ./
```
<br>


2. Docker run

```
$ docker run -d -p $TARGET_PORT:8080 --name file-service file-service:0.1
```
<br>

<br>

> API<br>
1. File Upload (post)<br>
```http://{baseUrl}/upload``` <br><br>
2. Multi-File Upload (post)<br> ```http://{baseUrl}/uploads``` <br><br>
3. File Download (get)<br>```http://{baseUrl}/download/{fileName+.}```
