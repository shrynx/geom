(ns thi.ng.geom.bench.core.vector
  (:require
   [thi.ng.geom.core :as g]
   [thi.ng.geom.utils :as gu]
   [thi.ng.geom.vector :as v :refer [vec2 vec3]]
   [thi.ng.math.core :as m :refer [*eps* HALF_PI PI]]
   [perforate-x.core :as perf :refer [defgoal defcase]]))

(def A2 (vec2 1 2))
(def B2 (vec2 10 20))
(def C2 (vec2 100 200))
(def D2 (vec2 1000 2000))

(def A3 (vec3 1 2 3))
(def B3 (vec3 10 20 30))
(def C3 (vec3 100 200 300))
(def D3 (vec3 1000 2000 3000))

(def N 10.0)
(def M 100.0)
(def O 1000.0)

(defgoal :vec2-ops "vec2-ops")

(defcase :vec2-ops :add-v
  [] #(m/+ A2 B2))

(defcase :vec2-ops :add-vv
  [] #(m/+ A2 B2 C2))

(defcase :vec2-ops :add-n
  [] #(m/+ A2 N))

(defcase :vec2-ops :add-nn
  [] #(m/+ A2 N M))

(defcase :vec2-ops :add-s
  [] #(m/+ A2 [N M]))

(defcase :vec2-ops :scale-v
  [] #(m/* A2 B2))

(defcase :vec2-ops :scale-n
  [] #(m/* A2 N))

(defcase :vec2-ops :madd
  [] #(m/madd A2 N B2))

(defcase :vec2-ops :madd-op2
  [] #(m/* (m/+ A2 N) B2))

(defcase :vec2-ops :dot
  [] #(m/dot A2 B2))

(defcase :vec2-ops :normalize
  [] #(m/normalize A2))

(defcase :vec2-ops :mag
  [] #(m/mag A2))

(defcase :vec2-ops :mag-squared
  [] #(m/mag-squared A2))

(defcase :vec2-ops :mix
  [] #(m/mix A2 B2 0.5))

(defcase :vec2-ops :mix-bi
  [] #(m/mix A2 B2 C2 D2 0.5 0.5))

(defcase :vec2-ops :rotate
  [] #(g/rotate A2 HALF_PI))
(defgoal :vec2-ops-mut "vec2-ops-mutable")

(defcase :vec2-ops-mut :add-v-ctor
  [] #(m/+ (vec2 1 2) B2))

(defcase :vec2-ops-mut :add-v!
  [] #(m/+! (vec2 1 2) B2))

(defcase :vec2-ops-mut :madd-v-ctor
  [] #(m/madd (vec2 1 2) N B2))

(defcase :vec2-ops-mut :madd-v!
  [] #(m/madd! (vec2 1 2) N B2))

(defgoal :vec3-ops "vec3-ops")

(defcase :vec3-ops :add-v
  [] #(m/+ A3 B3))

(defcase :vec3-ops :add-vv
  [] #(m/+ A3 B3 C3))

(defcase :vec3-ops :add-n
  [] #(m/+ A3 N))

(defcase :vec3-ops :add-nnn
  [] #(m/+ A3 N M O))

(defcase :vec3-ops :add-s
  [] #(m/+ A3 [N M O]))

(defcase :vec3-ops :scale-v
  [] #(m/* A3 B3))

(defcase :vec3-ops :scale-n
  [] #(m/* A3 N))

(defcase :vec3-ops :madd
  [] #(m/madd A3 N B3))

(defcase :vec3-ops :madd-op2
  [] #(m/* (m/+ A3 N) B3))

(defcase :vec3-ops :dot
  [] #(m/dot A3 B3))

(defcase :vec3-ops :cross
  [] #(m/cross A3 B3))

(defcase :vec3-ops :ortho-normal
  [] #(gu/ortho-normal A3 B3 C3))

(defcase :vec3-ops :normalize
  [] #(m/normalize A3))

(defcase :vec3-ops :mag
  [] #(m/mag A3))

(defcase :vec3-ops :mag-squared
  [] #(m/mag-squared A3))

(defcase :vec3-ops :mix
  [] #(m/mix A3 B3 0.5))

(defcase :vec3-ops :mix-bi
  [] #(m/mix A3 B3 C3 D3 0.5 0.5))

(defcase :vec3-ops :rotate-x
  [] #(g/rotate-x A3 HALF_PI))

(defcase :vec3-ops :rotate-axis
  [] #(g/rotate-around-axis A3 v/V3Y HALF_PI))

(perf/run-goals)
