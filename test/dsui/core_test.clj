(ns dsui.core-test
  (:use dsui.core)
  [:use clojure.test])

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

(def ms [{:a 1 :b 2 :c 3}
         {:a "1" :b 4/2 :c 3.0}
         {:a :A :b nil :c "idk?"}])
(deftest keys-to-v-test
  (is (= 3 (count (keys-to-v ms))))
  (is (= [:a :b :c] (keys-to-v ms))))
(deftest vals-to-vofv-test
  (is (= 3 (count (vals-to-vofv ms))))
  (is (= [[1 2 3]
          ["1" 2 3.0]
          [:A nil "idk?"]] (vals-to-vofv ms))))


(deftest table-model-test
  (let [tm (table-model '("A" "B" "c") [[1 2 3]
                                        [:1 :2 :3]
                                        ["1" nil 3.0]])]
    (is (= 3 (.getColumnCount tm)))))
