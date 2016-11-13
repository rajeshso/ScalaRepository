package patternMatching

/**
  * Created by E797240 on 10/11/2016.
  */
class SwitchMatch {

}

object SwitchMatch {
  def main(args: Array[String]): Unit = {
    //Examples for Literal Patterns - Auguest and 9
    //Example for Wild card - Note the case _ . _ is the wild card
    val month = "August"
    val quarter = month match {
      case "August" => "Third Quarter"
      case "January" => "First Quarter"
      case _ => "Incorrect month"
    }
    println(quarter)

    val monthNumber = 9
    val quarterNumber = monthNumber match {
      case 8 => "Third Quarter"
      case 1 => "First Quarter"
      case _ => "Incorrect month"
    }
    println(quarterNumber)

    //Example of Constructor match patterns
    val hero = new SuperHero(heroName = "Rajnikanth", alterEgo = "Superstar")
    hero match {
      case SuperHero("Rajnikanth", _) => println("Rajnikanth");
      case SuperHero("Kamal Hassan", _) => println("Kamal")
      case _ => println("Incorrect person");
    }
    //The constructor value has to be the exact type
    val person = new Person("Rajnikanth")
    person match {
      case SuperHero("Kamal Hassan", _) => println("Kamal")
      case SuperHero("Rajnikanth", _) => println("Rajnikanth");

      case _ => println("Incorrect person");
    }

    //One powerful example Application of Constructor pattern
    def alterHeroFor(person: Person) = {
      person match {
        case SuperHero("Rajni", superstar) => superstar
        case SuperHero("Kamal hassan", superstar) => superstar
        case _ => "Superzero"
      }
    }
    println(alterHeroFor(new SuperHero("Rajni", "Superstar11")))
    println(alterHeroFor(new SuperHero("Kamal hassan", "SuperActor")))

    //Type Query pattern
    val rajni = new SuperHero("Rajni", "Superstar")
    val kamal = new SuperHero("Kamal", "Superactor")
    val modi = new Person("Modi")

    def nameFor(person: Person): String = {
      person match {
        case hero: SuperHero => hero.alterEgo
        case person: Person => person.name
      }
    }
    println(nameFor(kamal)) // Note that there is no casting to find the type too.
    println(nameFor(modi)) //The practical application is instead of using instanceof, this technique can be used.

  }
}
  class Person(val name: String)

  case class SuperHero(heroName: String, alterEgo: String) extends Person(heroName)