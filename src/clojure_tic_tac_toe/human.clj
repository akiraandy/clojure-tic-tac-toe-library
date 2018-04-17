(ns clojure-tic-tac-toe.human
  (:require [clojure-tic-tac-toe.player :refer [play-turn]]
            [clojure-tic-tac-toe.console-ui :as console]
            [clojure-tic-tac-toe.messages :as messages]
            [clojure-tic-tac-toe.input-validation :refer [is-number?]]
            [clojure-tic-tac-toe.move-validation :refer [valid-move?]]
            [clojure-tic-tac-toe.board :as board]))

(defn- invalid-move [input] 
  (console/print-message(messages/invalid-input))
  (console/get-user-input))

(defn- valid-move-loop [input board]
 (if (and(is-number? input) (valid-move? board (Integer/parseInt input))) 
   input
   (recur(invalid-move input) board)))

(defn- select-space[board current-player]
  (console/print-message(messages/clear-screen))
  (console/print-message(messages/display-board board))
  (console/print-message(messages/turn-prompt current-player))
  (->
    (console/get-user-input)
    (valid-move-loop board)
    (read-string)))

(defmethod play-turn :human [game]
  (->
    (select-space (:board game) (:current-player game))
    (board/fill-board (:board game) (:current-player game))))
