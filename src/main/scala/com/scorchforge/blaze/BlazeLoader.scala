package com.scorchforge.blaze

import com.scorchforge.blaze.reference.Reference
import com.scorchforge.blaze.scripting.{ClassWrapper, PythonEngine}
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import org.apache.logging.log4j.LogManager

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, modLanguage = "scala")
object BlazeLoader {

  var log = LogManager.getLogger(Reference.MOD_NAME)
  var PyInterp = new PythonEngine()

  @EventHandler
  def preInit(e: FMLPreInitializationEvent) = {
    log = e.getModLog
    val test = new ClassWrapper(PyInterp, BlazeLoader.getClass.getResourceAsStream("python/main.py"), "Test")
    test.foo()
    BlazeLoader.log.info("Finished Pre-Init")
  }

  @EventHandler
  def init(e: FMLInitializationEvent) = {
    BlazeLoader.log.info("Finished Init")
  }

  @EventHandler
  def postInit(e: FMLPostInitializationEvent) = {
    BlazeLoader.log.info("Finished Post-Init")
  }

}
