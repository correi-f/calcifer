package fr.correia.bot

import ai.tock.bot.registerAndInstallBot

object CalciferBot {
    private val logger = KotlinLogging.logger {}

    internal fun runBot() {
        registerAndInstallBot()
    }
}

fun main() {
    CalciferBot.runBot()
}