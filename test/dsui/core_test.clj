(ns dsui.core-test
  (:use dsui.core)
  [:use clojure.test]
  (:require [clojure.spec.alpha :as s]))

(deftest scalar-test
  (is (scalar? 1))
  (is (not (scalar? []))))

(def scalarmap {:a 1 :b "2" :c 1/2})
(def nestmap {:a []})
(deftest scalar-map-tets
  (is (scalar-map? scalarmap))
  (is (not (scalar-map? nestmap))))

(def homo '({:a 1 :b 2} {:a "1" :b "2"} {:a 1/3 :b 3/7}))
(def inhomo  [{:a 1} {:b 2}])
(def inhomo2  [{:a 1} {:a 2 :b 3}])
(deftest homo-test
  (is (homogeneous? homo))
  (is (not (homogeneous? inhomo)))
  (is (not (homogeneous? inhomo2))))


(deftest table-model-test
  (let [tm (table-model '("A" "B" "c") [[1 2 3]
                                        [:1 :2 :3]])]
    (is (= 3 (.getColumnCount tm)))
    (is (= 2 (.getRowCount tm)))))


(def list-data ["a" "B" 1 2 3])
(deftest conform_conformed_data
  (let [conformed-data (s/conform :dsui.core/ds list-data)
        conformed²-data (s/conform :dsui.core/ds conformed-data)]
    (is (= conformed-data
           [:dsui.core/list-of-scalars ["a" "B" 1 2 3]]))
    (is (map-entry? conformed-data))
    (is (= conformed²-data
           [:dsui.core/labeled-ds [:dsui.core/list-of-scalars ["a" "B" 1 2 3]]]))))
