(ns front-end.core
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]])
  (:gen-class))

(defroutes koinonia
  (GET "/" [] "hello world"))

(defn -main []
  (run-server koinonia {:port 5000}))
