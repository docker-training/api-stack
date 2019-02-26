A hello-world java springboot api ala https://spring.io/guides/gs/rest-service/,
built by gradle in a container.

Usage:

```
docker image build -t myapi:13.0 .
docker container run -p 8080:8080 --network dblink myapi:13.0
```

Visit http://localhost:8080/demo/elt?Z=6
