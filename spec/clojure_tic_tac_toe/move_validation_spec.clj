(ns clojure-tic-tac-toe.move-validation-spec
  (:require [speclj.core :refer :all]
            [clojure-tic-tac-toe.move-validation :refer :all]))

(def board 
  [0 1 2 3 4 :x 6 7 8])

(describe "move-validation"
  (describe "valid-move?"
    (it "should return true if move is valid"
        (should= true (valid-move? board 4)))
    (it "should return false if the move is invalid"
        (should= false (valid-move? board 5))))) 
