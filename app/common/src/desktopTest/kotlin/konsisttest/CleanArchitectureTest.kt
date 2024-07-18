package konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.containingFiles
import com.lemonappdev.konsist.api.ext.list.withPackage
import com.lemonappdev.konsist.api.verify.assertFalse
import kotlin.test.Test

class CleanArchitectureTest {
	//.assertArchitecture{} is not used in order to make the tests generic
	@Test
	fun `checking that data layer does not depend on ui layer`() {
		Konsist.scopeFromProject() // project scope
			.packages // all project packages
			.containingFiles // all files in all the packages
			.withPackage("..data..") // filtering to only leave the files that are in the data package
			.assertFalse { file ->
				file.hasImport { imports ->
					imports.hasNameContaining(".ui.")
				} // asserting that those files do not depend on ui layer
			}
	}

	@Test
	fun `checking that ui layer does not depend on data layer`() {
		Konsist.scopeFromProject()
			.packages
			.containingFiles
			.withPackage("..ui..")
			.assertFalse { file ->
				file.hasImport { imports ->
					imports.hasNameContaining(".data.")
				}
			}
	}

	@Test
	fun `checking that domain layer depends on nothing`() {
		Konsist.scopeFromProject()
			.packages
			.containingFiles
			.withPackage("..domain..")
			.assertFalse { file ->
				file.hasImport { imports ->
					imports.hasNameContaining(".data.")
				} ||
					file.hasImport {
						it.hasNameContaining(".ui.")
					}
			}
	}
}
