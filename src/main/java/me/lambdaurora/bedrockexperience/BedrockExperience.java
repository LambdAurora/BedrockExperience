/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of BedrockExperience.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package me.lambdaurora.bedrockexperience;

import me.lambdaurora.bedrockexperience.gui.BedrockHud;
import me.lambdaurora.spruceui.hud.HudManager;
import net.fabricmc.api.ClientModInitializer;

/**
 * Represents the Bedrock Experience mod.
 *
 * @author LambdAurora
 * @version 1.0.0
 * @since 1.0.0
 */
public class BedrockExperience implements ClientModInitializer
{
    public static final String NAMESPACE = "bedrockexperience";
    public final BedrockExperienceConfig config = new BedrockExperienceConfig(this);

    @Override
    public void onInitializeClient()
    {
        this.config.load();
        HudManager.register(new BedrockHud(this));
    }
}
