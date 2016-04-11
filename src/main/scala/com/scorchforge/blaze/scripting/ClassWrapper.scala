package com.scorchforge.blaze.scripting

import language.dynamics
import java.io.{InputStream, InputStreamReader}

class ClassWrapper(engine: ScriptingEngine, input: InputStream, obj: String) extends scala.Dynamic {

  engine.engine.eval(new InputStreamReader(input))

  val python_utils = engine.engine.get(obj)

  def applyDynamic(name: String)(args: Any*) = {
    val argObjects = args.map(_.asInstanceOf[AnyRef])
    engine.engine.invokeMethod(python_utils, name, argObjects: _*)
  }
}
