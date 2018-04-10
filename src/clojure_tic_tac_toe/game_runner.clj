(ns clojure-tic-tac-toe.game-runner
  (:require [clojure.string :as string]
            [clojure-tic-tac-toe.board :as board]
            [clojure-tic-tac-toe.messages :as message]))

(defn get-user-input []
  (string/trim (read-line)))

(defn get-user-input-as-int []
  (Integer/parseInt(get-user-input)))

(defn turn [gameboard]
 (board/fill-board gameboard (get-user-input-as-int) :x))

(defn display-turn [gameboard]
  (message/display-board gameboard)
)

(defn game-loop [board]
  (if (board/full? board)
  board
  (recur (turn board))))
