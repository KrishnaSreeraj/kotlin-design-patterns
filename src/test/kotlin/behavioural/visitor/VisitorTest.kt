package behavioural.visitor

import org.assertj.core.api.Assertions
import org.example.behavioural.visitor.*
import org.junit.jupiter.api.Test

class VisitorTest {
    @Test
    fun visitorPattern() {
        val projectAlpha = FixedPriceContract(1000)
        val projectBeta = TimeAndMaterialsContract(100, 10)
        val projectGamma = SupportContract(500)
        val projectKappa = TimeAndMaterialsContract(50, 50)

        val projects = arrayListOf(projectAlpha, projectBeta, projectGamma, projectKappa)

        val monthlyCostReportVisitor = MonthlyCostReportVisitor()
        val monthlyCost = projects.sumOf { it.accept(monthlyCostReportVisitor) }
        println(monthlyCost)
        Assertions.assertThat(monthlyCost).isEqualTo(4083)

        val yearlyCostReportVisitor = YearlyCostReportVisitor()
        val yearlyCost = projects.sumOf { it.accept(yearlyCostReportVisitor) }
        println(yearlyCost)
        Assertions.assertThat(yearlyCost).isEqualTo(10500)
    }
}