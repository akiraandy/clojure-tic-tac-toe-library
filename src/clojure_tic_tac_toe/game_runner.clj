(ns clojure-tic-tac-toe.game-runner
  (:require [clojure.string :as string]
            [clojure-tic-tac-toe.board :as board]
            [clojure-tic-tac-toe.messages :as message]
            [clojure-tic-tac-toe.console-ui :as console]))

(defn get-user-input []
  (string/trim (read-line)))

(defn get-user-input-as-int []
  (Integer/parseInt(get-user-input)))

(defn turn [gameboard]
  (console/print-message(message/display-board gameboard))

  (let [user-input (get-user-input-as-int)]
 (board/fill-board gameboard user-input :x)))

(defn display-turn [gameboard]
  (message/display-board gameboard)
)

(defn game-loop [board]
  (if (board/full? board)
    board
  (recur (turn board))))
