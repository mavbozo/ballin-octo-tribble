(ns ballin-octo-tribble.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ballin-octo-tribble.routes.home :refer [home-routes]]
            [noir.session :as session]
            [ring.middleware.session.memory :refer [memory-store]]))

(defn init []
  (println "ballin-octo-tribble is starting"))

(defn destroy []
  (println "ballin-octo-tribble is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes home-routes app-routes)
      (wrap-base-url)
      (session/wrap-noir-session {:store (memory-store)})))
