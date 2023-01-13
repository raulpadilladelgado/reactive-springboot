# reactive-springboot

## Launch locally

In a terminal execute `make` to list available commands to start, stop and view the application logs

Then try the endpoints in a browser:
- (GET) http://127.0.0.1:8080/consume
- (GET) http://127.0.0.1:8080/consume-only-two
- (GET) http://127.0.0.1:8080/consume-for-five-seconds
- (POST) http://127.0.0.1:8080/song (body example: `{"name": "hola", "date": "2023-01-01"})

>  ⚠️ Don't use Postman or similar software because by default it has a blocking nature and you will not be able to 
> see the advantages of the reactive programming
