(ns clojure-tic-tac-toe.game-runner
  (:require [clojure.string :as string]
            [clojure-tic-tac-toe.board :as board]
            [clojure-tic-tac-toe.console-ui :as console]
            [clojure-tic-tac-toe.messages :as messages]
            [clojure-tic-tac-toe.rules :as rules]
            [clojure-tic-tac-toe.player :as player]
            [clojure-tic-tac-toe.turn-controller :as turn-contr]))

(defn turn [gamedata]
  (if (odd?(count(board/available-spaces (:board gamedata))))
    (merge gamedata { :board (player/play-turn {:player-type (get-in gamedata [:player1 :player-type]) :board (:board gamedata) :current-player (turn-contr/current-player (:board gamedata))})})
    (merge gamedata { :board (player/play-turn {:player-type (get-in gamedata [:player2 :player-type]) :board (:board gamedata) :current-player (turn-contr/current-player (:board gamedata))})})))

(defn game-loop [game-data]
  (if (rules/game-over? (:board game-data))
    (:board game-data)
  (recur (turn game-data))))

(defn play-game [game-data]
  (for [x (range 10)]
  (console/print-message(messages/clear-screen)))
  (let [end-state (game-loop game-data)]
    (console/print-message(messages/clear-screen))
    (console/print-message(messages/display-board end-state))
    (console/print-message(messages/end-game end-state))))
