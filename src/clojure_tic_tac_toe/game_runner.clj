(ns clojure-tic-tac-toe.game-runner
  (:require [clojure.string :as string]
            [clojure-tic-tac-toe.board :as board]
            [clojure-tic-tac-toe.console-ui :as console]
            [clojure-tic-tac-toe.messages :as messages]
            [clojure-tic-tac-toe.rules :as rules]
            [clojure-tic-tac-toe.player :as player]
            [clojure-tic-tac-toe.turn-controller :as turn-contr]))

(defn turn [gameboard]
  (if (odd?(count(board/available-spaces gameboard)))
    (player/play-turn {:player-type :human :board gameboard :current-player (turn-contr/current-player gameboard)})
    (player/play-turn {:player-type :computer :board gameboard :current-player (turn-contr/current-player gameboard) :opponent-player (turn-contr/opponent-player gameboard)})))

(defn game-loop [board]
  (if (rules/game-over? board)
    board
  (recur (turn board))))

(defn play-game [board]
  (let [end-state (game-loop board)]
    (print (str (char 27) "[2J"))
    (console/print-message(messages/display-board end-state))
    (console/print-message(messages/end-game end-state))))
