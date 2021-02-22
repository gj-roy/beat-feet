package com.serwylo.beatgame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.audio.Sound
import com.badlogic.gdx.graphics.g2d.ParticleEffect
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.ui.Skin

@Suppress("PropertyName") // Allow underscores in variable names here, because it better reflects the source files things come from.
class Assets {

    private val manager = AssetManager()
    private lateinit var skin: Skin
    private lateinit var sprites: Sprites
    private lateinit var particles: Particles
    private lateinit var sounds: Sounds

    init {
        manager.load("skin.json", Skin::class.java)
        manager.load("sprites.atlas", TextureAtlas::class.java)
        manager.load("effects/rainbow.p", ParticleEffect::class.java)
        manager.load("effects/health.p", ParticleEffect::class.java)

        // TODO: This doubles the loading time on my PC from 200ms to 400ms. Is it worth it?
        //       Perhaps we could procedurally generate the sound instead as it is relatively straightforward.
        manager.load("sounds/vibraphone_base_pitch.mp3", Sound::class.java)
    }

    fun initSync() {

        val startTime = System.currentTimeMillis()
        Gdx.app.debug(TAG, "Loading assets...")

        manager.finishLoading()

        skin = manager.get("skin.json")
        sprites = Sprites(manager.get("sprites.atlas"))
        particles = Particles(manager)
        sounds = Sounds(manager)

        Gdx.app.debug(TAG, "Finished loading assets (${System.currentTimeMillis() - startTime}ms)")

    }

    fun getSkin() = skin
    fun getSprites() = sprites
    fun getParticles() = particles
    fun getSounds() = sounds

    class Particles(manager: AssetManager) {
        val jump: ParticleEffect = manager.get("effects/rainbow.p")
        val health: ParticleEffect = manager.get("effects/health.p")
    }

    class Sounds(manager: AssetManager) {
        val scale: Sound = manager.get("sounds/vibraphone_base_pitch.mp3")
    }

    class Sprites(atlas: TextureAtlas) {
        val barrel_a: TextureRegion = atlas.findRegion("barrel_a")
        val barrel_b: TextureRegion = atlas.findRegion("barrel_b")
        val barrel_c: TextureRegion = atlas.findRegion("barrel_c")
        val barrier_a: TextureRegion = atlas.findRegion("barrier_a")
        val barrier_b: TextureRegion = atlas.findRegion("barrier_b")
        val barrier_c: TextureRegion = atlas.findRegion("barrier_c")
        val barrier_d: TextureRegion = atlas.findRegion("barrier_d")
        val bin_medium_a: TextureRegion = atlas.findRegion("bin_medium_a")
        val bin_medium_b: TextureRegion = atlas.findRegion("bin_medium_b")
        val bin_small_a: TextureRegion = atlas.findRegion("bin_small_a")
        val bin_small_b: TextureRegion = atlas.findRegion("bin_small_b")
        val box_large: TextureRegion = atlas.findRegion("box_large")
        val box_medium: TextureRegion = atlas.findRegion("box_medium")
        val box_small: TextureRegion = atlas.findRegion("box_small")
        val building_a_bottom_left: TextureRegion = atlas.findRegion("building_a_bottom_left")
        val building_a_bottom: TextureRegion = atlas.findRegion("building_a_bottom")
        val building_a_bottom_right: TextureRegion = atlas.findRegion("building_a_bottom_right")
        val building_a_inner: TextureRegion = atlas.findRegion("building_a_inner")
        val building_a_left: TextureRegion = atlas.findRegion("building_a_left")
        val building_a_right: TextureRegion = atlas.findRegion("building_a_right")
        val building_a_top_left: TextureRegion = atlas.findRegion("building_a_top_left")
        val building_a_top: TextureRegion = atlas.findRegion("building_a_top")
        val building_a_top_right: TextureRegion = atlas.findRegion("building_a_top_right")
        val building_b_bottom_left: TextureRegion = atlas.findRegion("building_b_bottom_left")
        val building_b_bottom: TextureRegion = atlas.findRegion("building_b_bottom")
        val building_b_bottom_right: TextureRegion = atlas.findRegion("building_b_bottom_right")
        val building_b_inner: TextureRegion = atlas.findRegion("building_b_inner")
        val building_b_left: TextureRegion = atlas.findRegion("building_b_left")
        val building_b_right: TextureRegion = atlas.findRegion("building_b_right")
        val building_b_top_left: TextureRegion = atlas.findRegion("building_b_top_left")
        val building_b_top: TextureRegion = atlas.findRegion("building_b_top")
        val building_b_top_right: TextureRegion = atlas.findRegion("building_b_top_right")
        val building_c_bottom_left: TextureRegion = atlas.findRegion("building_c_bottom_left")
        val building_c_bottom: TextureRegion = atlas.findRegion("building_c_bottom")
        val building_c_bottom_right: TextureRegion = atlas.findRegion("building_c_bottom_right")
        val building_c_inner: TextureRegion = atlas.findRegion("building_c_inner")
        val building_c_left: TextureRegion = atlas.findRegion("building_c_left")
        val building_c_right: TextureRegion = atlas.findRegion("building_c_right")
        val building_c_top_left: TextureRegion = atlas.findRegion("building_c_top_left")
        val building_c_top: TextureRegion = atlas.findRegion("building_c_top")
        val building_c_top_right: TextureRegion = atlas.findRegion("building_c_top_right")
        val bush_medium_a: TextureRegion = atlas.findRegion("bush_medium_a")
        val bush_medium_b: TextureRegion = atlas.findRegion("bush_medium_b")
        val bush_medium_c: TextureRegion = atlas.findRegion("bush_medium_c")
        val bush_small_a: TextureRegion = atlas.findRegion("bush_small_a")
        val bush_small_b: TextureRegion = atlas.findRegion("bush_small_b")
        val bush_small_c: TextureRegion = atlas.findRegion("bush_small_c")
        val character_a_dance_a: TextureRegion = atlas.findRegion("character_a_dance_a")
        val character_a_dance_b: TextureRegion = atlas.findRegion("character_a_dance_b")
        val character_a_duck: TextureRegion = atlas.findRegion("character_a_duck")
        val character_a_face: TextureRegion = atlas.findRegion("character_a_face")
        val character_a_face_small: TextureRegion = atlas.findRegion("character_a_face_small")
        val character_a_front: TextureRegion = atlas.findRegion("character_a_front")
        val character_a_hit: TextureRegion = atlas.findRegion("character_a_hit")
        val character_a_jump: TextureRegion = atlas.findRegion("character_a_jump")
        val character_a_walk = atlas.findRegions("character_a_walk")
        val door_a_closed: TextureRegion = atlas.findRegion("door_a_closed")
        val door_a_covered: TextureRegion = atlas.findRegion("door_a_covered")
        val door_a_open: TextureRegion = atlas.findRegion("door_a_open")
        val door_b_closed: TextureRegion = atlas.findRegion("door_b_closed")
        val door_b_covered: TextureRegion = atlas.findRegion("door_b_covered")
        val door_b_open: TextureRegion = atlas.findRegion("door_b_open")
        val door_c_closed: TextureRegion = atlas.findRegion("door_c_closed")
        val door_c_covered: TextureRegion = atlas.findRegion("door_c_covered")
        val door_c_open: TextureRegion = atlas.findRegion("door_c_open")
        val door_d_closed: TextureRegion = atlas.findRegion("door_d_closed")
        val door_d_covered: TextureRegion = atlas.findRegion("door_d_covered")
        val door_d_open: TextureRegion = atlas.findRegion("door_d_open")
        val door_e_closed: TextureRegion = atlas.findRegion("door_e_closed")
        val door_e_covered: TextureRegion = atlas.findRegion("door_e_covered")
        val door_e_open: TextureRegion = atlas.findRegion("door_e_open")
        val door_f_closed: TextureRegion = atlas.findRegion("door_f_closed")
        val door_f_covered: TextureRegion = atlas.findRegion("door_f_covered")
        val door_f_open: TextureRegion = atlas.findRegion("door_f_open")
        val fence_inner_broken_a: TextureRegion = atlas.findRegion("fence_inner_broken_a")
        val fence_inner_broken_b: TextureRegion = atlas.findRegion("fence_inner_broken_b")
        val fence_inner: TextureRegion = atlas.findRegion("fence_inner")
        val fence_left: TextureRegion = atlas.findRegion("fence_left")
        val fence_right: TextureRegion = atlas.findRegion("fence_right")
        val ghost: TextureRegion = atlas.findRegion("ghost")
        val ghost_x: TextureRegion = atlas.findRegion("ghost_x")
        val ground_a: TextureRegion = atlas.findRegion("ground_a")
        val ground_b: TextureRegion = atlas.findRegion("ground_b")
        val ground_c: TextureRegion = atlas.findRegion("ground_c")
        val ground_d: TextureRegion = atlas.findRegion("ground_d")
        val ground_e: TextureRegion = atlas.findRegion("ground_e")
        val ground_f: TextureRegion = atlas.findRegion("ground_f")
        val heart_empty: TextureRegion = atlas.findRegion("heart_empty")
        val heart_half: TextureRegion = atlas.findRegion("heart_half")
        val heart: TextureRegion = atlas.findRegion("heart")
        val hydrant: TextureRegion = atlas.findRegion("hydrant")
        val logo: TextureRegion = atlas.findRegion("logo")
        val mail_box: TextureRegion = atlas.findRegion("mail_box")
        val particle_pixel: TextureRegion = atlas.findRegion("particle_pixel")
        val right_sign: TextureRegion = atlas.findRegion("right_sign")
        val score: TextureRegion = atlas.findRegion("score")
        val star: TextureRegion = atlas.findRegion("star")
        val streetlight_a_base: TextureRegion = atlas.findRegion("streetlight_a_base")
        val streetlight_a_post: TextureRegion = atlas.findRegion("streetlight_a_post")
        val streetlight_a_top: TextureRegion = atlas.findRegion("streetlight_a_top")
        val streetlight_b_base: TextureRegion = atlas.findRegion("streetlight_b_base")
        val streetlight_b_post: TextureRegion = atlas.findRegion("streetlight_b_post")
        val streetlight_b_top: TextureRegion = atlas.findRegion("streetlight_b_top")
        val streetlight_c_base: TextureRegion = atlas.findRegion("streetlight_c_base")
        val streetlight_c_post: TextureRegion = atlas.findRegion("streetlight_c_post")
        val streetlight_c_top: TextureRegion = atlas.findRegion("streetlight_c_top")
        val streetlight_d_base: TextureRegion = atlas.findRegion("streetlight_d_base")
        val streetlight_d_post: TextureRegion = atlas.findRegion("streetlight_d_post")
        val streetlight_d_top: TextureRegion = atlas.findRegion("streetlight_d_top")
        val streetlight_e_base: TextureRegion = atlas.findRegion("streetlight_e_base")
        val streetlight_e_post: TextureRegion = atlas.findRegion("streetlight_e_post")
        val streetlight_e_top: TextureRegion = atlas.findRegion("streetlight_e_top")
        val streetlight_f_base: TextureRegion = atlas.findRegion("streetlight_f_base")
        val streetlight_f_post: TextureRegion = atlas.findRegion("streetlight_f_post")
        val streetlight_f_top: TextureRegion = atlas.findRegion("streetlight_f_top")
        val tyre: TextureRegion = atlas.findRegion("tyre")
        val tyres_large: TextureRegion = atlas.findRegion("tyres_large")
        val tyres_medium: TextureRegion = atlas.findRegion("tyres_medium")
        val tyres_small: TextureRegion = atlas.findRegion("tyres_small")
        val wall_a_inner: TextureRegion = atlas.findRegion("wall_a_inner")
        val wall_a_left: TextureRegion = atlas.findRegion("wall_a_left")
        val wall_a_right: TextureRegion = atlas.findRegion("wall_a_right")
        val wall_b_inner: TextureRegion = atlas.findRegion("wall_b_inner")
        val wall_b_left: TextureRegion = atlas.findRegion("wall_b_left")
        val wall_b_right: TextureRegion = atlas.findRegion("wall_b_right")
        val wall_c_inner: TextureRegion = atlas.findRegion("wall_c_inner")
        val wall_c_left: TextureRegion = atlas.findRegion("wall_c_left")
        val wall_c_right: TextureRegion = atlas.findRegion("wall_c_right")
        val window_steel_a: TextureRegion = atlas.findRegion("window_steel_a")
        val window_steel_b: TextureRegion = atlas.findRegion("window_steel_b")
        val window_steel_c: TextureRegion = atlas.findRegion("window_steel_c")
        val window_steel_d: TextureRegion = atlas.findRegion("window_steel_d")
        val window_steel_e: TextureRegion = atlas.findRegion("window_steel_e")
        val window_steel_f: TextureRegion = atlas.findRegion("window_steel_f")
        val window_steel_g: TextureRegion = atlas.findRegion("window_steel_g")
        val window_steel_h: TextureRegion = atlas.findRegion("window_steel_h")
        val window_steel_i: TextureRegion = atlas.findRegion("window_steel_i")
        val window_steel_j: TextureRegion = atlas.findRegion("window_steel_j")
        val window_wood_a: TextureRegion = atlas.findRegion("window_wood_a")
        val window_wood_b: TextureRegion = atlas.findRegion("window_wood_b")
        val window_wood_c: TextureRegion = atlas.findRegion("window_wood_c")
        val window_wood_d: TextureRegion = atlas.findRegion("window_wood_d")
        val window_wood_e: TextureRegion = atlas.findRegion("window_wood_e")
        val window_wood_f: TextureRegion = atlas.findRegion("window_wood_f")
        val window_wood_g: TextureRegion = atlas.findRegion("window_wood_g")
        val window_wood_h: TextureRegion = atlas.findRegion("window_wood_h")
        val window_wood_i: TextureRegion = atlas.findRegion("window_wood_i")
        val window_wood_j: TextureRegion = atlas.findRegion("window_wood_j")
    }

    companion object {

        private const val TAG = "Assets"

        private val SCALE_SOUND_FILES = listOf(
                "n01.mp3",
                "n02.mp3",
                "n03.mp3",
                "n04.mp3",
                "n05.mp3",
                "n06.mp3",
                "n07.mp3",
                "n08.mp3",
                "n09.mp3",
                "n10.mp3",
                "n11.mp3",
                "n12.mp3",
                "n13.mp3",
                "n14.mp3",
                "n15.mp3",
                "n16.mp3",
                "n17.mp3",
                "n18.mp3",
                "n19.mp3",
                "n20.mp3",
                "n21.mp3",
                "n22.mp3",
                "n23.mp3",
                "n24.mp3"
        )

    }

}