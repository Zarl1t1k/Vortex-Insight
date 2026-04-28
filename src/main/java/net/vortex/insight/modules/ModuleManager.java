package net.vortex.insight.modules;

import java.util.HashMap;
import java.util.Map;

public class ModuleManager {
    // Хранилище: Название модуля -> Включен он или нет
    public static final Map<String, Boolean> modules = new HashMap<>();

    static {
        // По умолчанию всё выключено
        modules.put("Sprint", false);
        modules.put("FullBright", false);
        modules.put("Velocity", false);
    }

    public static boolean isEnabled(String name) {
        return modules.getOrDefault(name, false);
    }

    public static void toggle(String name) {
        modules.put(name, !isEnabled(name));
    }
}
