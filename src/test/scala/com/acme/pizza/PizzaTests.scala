package com.acme.pizza

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class PizzaTests extends FunSuite with BeforeAndAfter {
  
  var pizza: Pizza = _

  before {
    pizza = new Pizza
  }

  test("new pizza has zero toppings") {
    assert(pizza.getToppings.size == 0)
  }

  test("new pizza has zero toppings (version 2") {
    assert(pizza.getToppings.size === 1)
  }

  test("new pizza has zero toppings (version 3") {
    // 'expectResult' is now 'assertResult'
    expectResult(1) {
        pizza.getToppings.size
      }
  }

  test("adding one topping") {
    pizza.addTopping(Topping("green olives"))
    assert(pizza.getToppings.size === 1)
  }

  // mark that you want a test here in the future
  test ("test pizza pricing") (pending)

  test ("should allow removal of toppings") (pending)

  test ("catching an exception") {
    val thrown = intercept[Exception] {
      pizza.boom
    }
    assert(thrown.getMessage === "Boom!")
  }

  test ("catching an exception") {
    intercept[Exception] { pizza.boom }
  }

  test("new pizza has zero toppings", DatabaseTest, WsTest) {
    //assert(pizza.getToppings.size === 1)
    expectResult(0) {
      pizza.getToppings.size
    }
  }

}