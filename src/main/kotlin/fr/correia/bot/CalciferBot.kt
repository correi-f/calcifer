package fr.correia.bot

import ai.tock.bot.registerAndInstallBot
import mu.KotlinLogging

object CalciferBot {
    private val logger = KotlinLogging.logger {}

    internal fun runBot() {
        registerAndInstallBot(calciferBot)
    }
}

fun main() {
    CalciferBot.runBot()
}