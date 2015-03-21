# Koinonia front-end

Clojure front-end application, which displays specified shared image and allows user to create a new sharable image URL.

## Usage

```bash
lein run -m front-end.core
```

## Docker container

```bash
docker build --rm -t testing_frontend .
docker run -d -p 8080:5000 testing_frontend
curl $(boot2docker ip):8080
```

## License

Copyright © 2015 Integralist

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
