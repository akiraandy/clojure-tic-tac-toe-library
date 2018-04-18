(ns clojure-tic-tac-toe.game-runner-spec
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.game-runner :refer :all]))
(def game-data 
  {:board [0 1 2 3 4 5 6 7 8] :player1 {:player-type :human} :player2 {:player-type :human}})

(describe "game-runner"
  (describe "turn"
    (around [it]
      (with-out-str (it)))
    (it "returns a map of game data"
        (should= {:board [:x 1 2 3 4 5 6 7 8] :player1 {:player-type :human} :player2 {:player-type :human}} (with-in-str "0"(turn game-data)))))) 
