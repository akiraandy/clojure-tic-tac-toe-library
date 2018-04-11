(ns clojure-tic-tac-toe.console-ui) 

(defn print-message [message]
  (println message))

(defn get-user-input []
  (read-line))
