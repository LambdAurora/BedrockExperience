/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of BedrockExperience.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package me.lambdaurora.bedrockexperience.gui.component;

import me.lambdaurora.bedrockexperience.BedrockExperienceConfig;
import me.lambdaurora.spruceui.hud.HudComponent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.text.TranslatableText;
import org.aperlambda.lambdacommon.Identifier;
import org.jetbrains.annotations.NotNull;

public class CoordinatesIndicator extends HudComponent
{
    private static final String TRANSLATION_KEY = "bedrockexperience.hud.position";
    private final BedrockExperienceConfig config;
    private final MinecraftClient         client;

    public CoordinatesIndicator(int x, int y, @NotNull BedrockExperienceConfig config)
    {
        super(new Identifier("bedrockexperience", "hud/coordinates"), x, y);
        this.config = config;
        this.client = MinecraftClient.getInstance();

        this.setEnabled(config.hasCoordinatesIndicator());
    }

    @Override
    public void render(float tickDelta)
    {
        Entity camera = this.client.getCameraEntity();
        if (camera == null)
            return;

        double d = Math.pow(10, this.config.getCoordinatesDecimalsAmount());
        double posX = Math.round(camera.getX() * d) / d;
        double posY = Math.round(camera.getY() * d) / d;
        double posZ = Math.round(camera.getZ() * d) / d;

        String text;
        if (this.config.getCoordinatesDecimalsAmount() <= 0) {
            // Integer coordinates.
            text = new TranslatableText(TRANSLATION_KEY, (int) posX, (int) posY, (int) posZ).asString();
        } else {
            text = new TranslatableText(TRANSLATION_KEY, posX, posY, posZ).asString();
        }
        int width = this.client.textRenderer.getStringWidth(text) + 4;

        int alpha = (int) ((this.client.options.chatOpacity * 0.9f + 0.1f) * 255.f);

        if (this.config.hasCoordinatesIndicatorBackground()) {
            fill(this.x, this.y, this.x + width, this.y + this.client.textRenderer.fontHeight + 4, alpha / 2 << 24);
        }

        this.client.textRenderer.drawWithShadow(text, x + 2, y + 3, 16777215 + (alpha << 24));
    }
}
