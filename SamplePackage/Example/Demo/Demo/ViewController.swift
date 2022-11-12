//
//  ViewController.swift
//  Demo
//
//  Created by Egor Anikeev on 12.11.2022.
//

import UIKit
import SamplePackage
import SampleCocoapods

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        print(SamplePackage.SampleClass().text)
        print(SampleCocoapods.SampleClass().text)
    }


}

