(ns clojure-tic-tac-toe.core
  (import Parser.ArgumentParser)
  (:require [clojure-tic-tac-toe.console-ui :as console-ui]
            [clojure-tic-tac-toe.board :as board]
            [clojure-tic-tac-toe.messages :as messages]
            [clojure-tic-tac-toe.human :as human]
            [clojure-tic-tac-toe.computer :as computer]
            [clojure-tic-tac-toe.game-runner :refer :all])
  (:gen-class))


(def empty-board 
  [0 1 2 3 4 5 6 7 8])

(defn -main
  [& args]
  (let [ag (ArgumentParser.)]
    (.addFlag ag "-t" "gameType")
    (.addFlag ag "--type" "gameType")
    (let [game-type (keyword (get (.parse ag (into-array args)) "gameType"))]
      (play-game {:game-type game-type :board empty-board}))))
