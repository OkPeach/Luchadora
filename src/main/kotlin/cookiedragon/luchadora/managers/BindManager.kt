package cookiedragon.luchadora.managers

import cookiedragon.eventsystem.EventDispatcher.Companion.register
import cookiedragon.eventsystem.EventDispatcher.Companion.subscribe
import cookiedragon.eventsystem.Subscriber
import cookiedragon.luchadora.event.client.KeyPressedEvent
import cookiedragon.luchadora.util.Initialisable
import cookiedragon.luchadora.util.Key

/**
 * @author cookiedragon234 15/Feb/2020
 */
object BindManager: Initialisable() {
	init {
		register(this)
		subscribe(this)
	}
	
	@Subscriber
	private fun onKeyPress(event: KeyPressedEvent) {
		if (event.key == Key.KEY_NONE) return
		
		for (module in ModuleManager.getModules()) {
			if (module.keyBind.value == event.key) {
				module.toggle()
			}
		}
	}
}
