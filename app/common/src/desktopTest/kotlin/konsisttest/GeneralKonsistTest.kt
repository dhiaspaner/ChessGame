package konsisttest

import com.lemonappdev.konsist.api.KoModifier
import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.modifierprovider.withModifier
import com.lemonappdev.konsist.api.ext.list.properties
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertFalse
import com.lemonappdev.konsist.api.verify.assertTrue
import kotlin.test.Test

class GeneralKonsistTest {

	@Test
	fun `no empty files allowed`() {
		Konsist.scopeFromProject()
			.files
			.assertFalse { it.text.isEmpty() }
	}
	@Test
	fun `data classes proprieties are immutable`() {
		Konsist
			.scopeFromProduction()
			.classes()
			.withModifier(KoModifier.DATA)
			.properties(
				includeNested = true,
				includeLocal = true,
			)
			.assertTrue {
				it.hasValModifier
			}
	}

	@Test
	fun `every interface with Repository suffix reside in 'domain', 'repository' packages`() {
		Konsist
			.scopeFromProduction()
			.interfaces()
			.withNameEndingWith("Repository")
			.assertTrue { it.resideInPackage("..domain.repository..") }
	}


}