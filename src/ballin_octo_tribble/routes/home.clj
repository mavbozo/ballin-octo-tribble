(ns ballin-octo-tribble.routes.home
  (:require [compojure.core :refer :all]
            [ballin-octo-tribble.views.layout :as layout]
            [noir.session :as session]))

(defn home []
  (layout/common [:h1 "Hello World!"]))

(defn insert-record
  ""
  []
  (session/put! :id "123"))


(defn get-record
  ""
  []
  (session/get :id))

(defroutes home-routes
  (GET "/" [] (home))
  (GET "/put-session" [] 
       (insert-record))
  (GET "/get-session" []
       (get-record)))
