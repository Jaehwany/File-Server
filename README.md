# FileServer

Spring Boot + docker로 구성한 나만의 파일 서버
<br><br>


- Implement Method

```
$ sudo docker-compose up -d
```
<br>

- port<br>
```
-8800:8080
```
<br>

- API<br>
1. File Upload (post)<br>
```http://{baseUrl}/image/uploadFile``` <br><br>
2. Multi-File Upload (post)<br> ```http://{baseUrl}/image/uploadMultipleFiles``` <br><br>
3. File Download (get)<br>```http://{baseUrl}/image/downloadFile/{fileName+.}```
