(ns clojure-tic-tac-toe.computer_spec 
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.player :refer :all]
            [clojure-tic-tac-toe.board :as board]
            ))

(def empty-board
  [
   0 1 2 
   3 4 5 
   6 7 8
   ])

(def take-random-board
  [
   :x 1 2
   3 :o 5
   6 :x 8
   ])

(def take-middle-board
  [:x 1 2
   3 4 5
   6 7 8
   ])

(def winning-board
  [
   :o :x :x
   :o :x 5
   6 7 8
   ]
  )

(def losing-board
  [:x :x 2
   3 :o 5
   6 7 8
   ])

(def losing-board-diagonal
  [
   0 1 :x 
   :o :x 5
   6 7 8
   ]
  )

(def losing-board-col
  [
   0 1 :x
   :o 4 :x
   6 7 8
   ]
  )

(def full-board
  [:x :o :x
   :o :o :x
   :x :x :o
   ])

(describe "computer"
  (describe "play-turn"
    (it "takes winning move if available"
      (should= [:o :x :x :o :x 5 :o 7 8] (play-turn {:player-type :computer :board winning-board :current-player :o})))
    (it "should block if available"
      (should= [:x :x :o 3 :o 5 6 7 8] (play-turn {:player-type :computer :board losing-board :current-player :o :opponent-player :x}))
      (should= [0 1 :x :o :x 5 :o 7 8] (play-turn {:player-type :computer :board losing-board-diagonal :current-player :o :opponent-player :x}))
      (should= [0 1 :x :o 4 :x 6 7 :o] (play-turn {:player-type :computer :board losing-board-col :current-player :o :opponent-player :x})))
    (it "should take corner if board is empty"
      (should-contain :o (play-turn {:player-type :computer :board empty-board :current-player :o :opponent-player :x})))
    (it "should take the middle if other conditions not met"
      (should= [:x 1 2 3 :o 5 6 7 8] (play-turn {:player-type :computer :board take-middle-board :current-player :o :opponent-player :x})))
    (it "should take random spot if other conditions not met"
      (should= 5 (count (board/available-spaces (play-turn {:player-type :computer :board take-random-board :current-player :o :opponent-player :x})))))
    (it "should return the same board if there are no valid moves"
        (should= full-board (play-turn {:player-type :computer :board full-board :current-player :o :opponent-player :x}))))) 
