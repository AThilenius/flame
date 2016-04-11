package com.scorchforge.blaze.scripting

import javax.script.{Invocable, ScriptEngineManager, ScriptEngine}

trait ScriptingEngine {
  protected val scriptEngineManager = new ScriptEngineManager()
  protected val langEngine: ScriptEngine
  val engine = langEngine.asInstanceOf[ScriptEngine with Invocable]
}
