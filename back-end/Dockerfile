FROM bbcnews/wraith
RUN mkdir -p /back-end
WORKDIR /back-end
COPY Gemfile /back-end/
RUN bundle install --quiet
COPY . /back-end
ENTRYPOINT ["ruby"]
CMD ["app.rb"]
