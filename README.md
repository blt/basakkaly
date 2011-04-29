basakkaly - An Akka/Scala sbt quickstart project.
===============

I find myself starting several, small Akka projects per week. Each has a
non-trivial amount of configuration involved. This project, like Gnu's
[Hello](http://www.gnu.org/software/hello/) is meant to remove the need for
such repeated work.

Features:

  * Latest Akka 1.1-M1,
  * quick deployment with [sbt-akka-bivy](https://github.com/bwmcadams/sbt-akka-bivy)
  * and a permissive license.

Getting Started
---------------

Kindly do these things:

```
> sbt reload update compile test akka-deploy
> sh akka/bookAkka
```