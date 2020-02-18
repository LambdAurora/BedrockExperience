/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of BedrockExperience.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package me.lambdaurora.bedrockexperience.gui;

import me.lambdaurora.bedrockexperience.BedrockExperience;
import me.lambdaurora.bedrockexperience.gui.component.CoordinatesIndicator;
import me.lambdaurora.spruceui.hud.Hud;
import net.minecraft.client.MinecraftClient;
import org.aperlambda.lambdacommon.Identifier;
import org.jetbrains.annotations.NotNull;

public class BedrockHud extends Hud
{
    private final BedrockExperience mod;

    public BedrockHud(@NotNull BedrockExperience mod)
    {
        super(new Identifier("bedrockexperience", "hud"));
        this.mod = mod;
    }

    @Override
    public void init(@NotNull MinecraftClient client, int screenWidth, int screenHeight)
    {
        super.init(client, screenWidth, screenHeight);
        this.components.add(new CoordinatesIndicator(2, 2, this.mod.config));
    }
}
