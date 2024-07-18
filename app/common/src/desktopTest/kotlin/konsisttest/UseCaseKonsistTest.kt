package konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertTrue
import kotlin.test.Test

class UseCaseKonsistTest {
	@Test
	fun `classes with 'UseCase' suffix should have single public operator method named 'invoke'`() {
		Konsist
			.scopeFromProject()
			.classes()
			.withNameEndingWith("UseCase")
			.assertTrue {
				val hasSingleInvokeOperatorMethod = it.hasFunction { function ->
					function.name == "invoke" && function.hasPublicOrDefaultModifier && function.hasOperatorModifier
				}
				hasSingleInvokeOperatorMethod && it.numPublicOrDefaultDeclarations() == 1
			}
	}
}