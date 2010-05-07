package scalanlp.concurrent

import org.scalatest._;
import org.scalatest.junit._;
import org.scalatest.prop._;
import org.scalacheck._;
import org.junit.runner.RunWith;

@RunWith(classOf[JUnitRunner])
class ParallelOpsTest extends FunSuite with Checkers {
  import ParallelOps._;
  test("sum works") {
    assert((1 to 100).par.fold(0)(_ + _)(_ + _) === (1 to 100).foldLeft(0)(_ + _));
    assert((1 to 100).par.reduce(_+_) === (1 to 100).foldLeft(0)(_ + _));
  }
}
