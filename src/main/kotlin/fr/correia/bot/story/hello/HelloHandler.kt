package fr.correia.bot.story.hello

import ai.tock.bot.connector.ConnectorMessage
import ai.tock.bot.connector.web.WebHandler
import ai.tock.bot.definition.*
import ai.tock.bot.engine.BotBus
import fr.correia.bot.CalciferIntent
import fr.correia.bot.story.hello.web.HelloWeb
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

enum class HelloStep: StoryStep<HelloDef> {
    HELLO {
        override fun answer(): HelloDef.() -> Any? = {
            step = null
            end {

            }
        }
    }
}

val hello = storyDefWithSteps<HelloDef, HelloStep>(CalciferIntent.hello.wrappedIntent().name) {
    logger.debug { "start story hello" }
    resetDialogState()
}

@WebHandler(HelloWeb::class)
class HelloDef(bus: BotBus): HandlerDef<HelloConnector>(bus) {
    override fun answer() {
        withMessage(
            connector!!.greetings()
        )
        end()
        logger.debug { "end story hello" }
    }
}

abstract class HelloConnector(context: HelloDef): ConnectorDef<HelloDef>(context) {
    abstract fun greetings(): ConnectorMessage
}