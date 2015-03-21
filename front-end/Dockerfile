FROM clojure
RUN mkdir -p /front-end
WORKDIR /front-end
COPY project.clj /front-end/
RUN lein deps
COPY . /front-end
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar
EXPOSE 5000
CMD ["java", "-jar", "app-standalone.jar"]
