package com.scorchforge.blaze.scripting

import javax.script.{ScriptEngineManager, ScriptEngine}

class PythonEngine extends ScriptingEngine {
  protected val scriptEngineManager = new ScriptEngineManager()
  protected val langEngine = scriptEngineManager.getEngineByName("python")
}
