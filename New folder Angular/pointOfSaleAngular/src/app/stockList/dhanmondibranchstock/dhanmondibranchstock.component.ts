import { Component, OnInit, ElementRef, ViewChild, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { ProductService } from '../../service/product.service';
import { ProductModule } from '../../module/product/product.module';
import { Chart } from 'chart.js/auto';

@Component({
  selector: 'app-dhanmondibranchstock',
  templateUrl: './dhanmondibranchstock.component.html',
  styleUrls: ['./dhanmondibranchstock.component.css']
})
export class DhanmondibranchstockComponent implements OnInit {
  products: ProductModule[] = [];
  productNames: string[] = [];
  productStocks: number[] = [];
  isBrowser: boolean;

  @ViewChild('barChart') barChart!: ElementRef<HTMLCanvasElement>;
  chart: Chart | null = null;

  constructor(
    private productService: ProductService,
    @Inject(PLATFORM_ID) private platformId: Object // Inject platform ID
  ) {
    this.isBrowser = isPlatformBrowser(this.platformId); // Determine if running in the browser
  }

  ngOnInit(): void {
    if (this.isBrowser) {
      // Only load products and render the chart in the browser
      this.getAllProducts();
    }
  }

  getAllProducts() {
    this.productService.getAllDhanmondiBrancesProduct().subscribe(
      (res) => {
        this.products = res;

        // Prepare data for the chart
        this.productNames = this.products.map((product) => product.name);
        this.productStocks = this.products.map((product) => product.stock);

        // Render the bar chart
        this.renderBarChart();
      },
      (err) => {
        console.error(err);
      }
    );
  }

  renderBarChart() {
    if (!this.isBrowser) return; // Avoid rendering in non-browser environments

    if (this.chart) {
      this.chart.destroy(); // Destroy the existing chart instance to avoid duplicates
    }

    // Generate an array of colors for each bar
    const colors = this.productStocks.map((_, index) =>
      `hsl(${(index * 60) % 360}, 70%, 50%)`
    );

    this.chart = new Chart(this.barChart.nativeElement, {
      type: 'bar',
      data: {
        labels: this.productNames,
        datasets: [
          {
            label: 'Stock Levels',
            data: this.productStocks,
            backgroundColor: colors, // Use the generated colors
            borderColor: colors.map((color) => color.replace('50%', '40%')), // Darker border for contrast
            borderWidth: 1,
          },
        ],
      },
      options: {
        responsive: true,
        plugins: {
          legend: {
            position: 'top',
          },
        },
        scales: {
          y: {
            beginAtZero: true,
          },
        },
      },
    });
  }
}
