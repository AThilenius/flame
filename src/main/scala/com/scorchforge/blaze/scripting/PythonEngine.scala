package com.scorchforge.blaze.scripting

class PythonEngine extends ScriptingEngine {
  protected val langEngine = scriptEngineManager.getEngineByName("python")
}
